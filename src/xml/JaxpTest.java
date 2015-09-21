package xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by yeqf on 2015/9/21.
 */
public class JaxpTest {

    @Test
    public void read1() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src\\book.xml");
        NodeList list = document.getElementsByTagName("province");
        System.out.println(list.getLength());
        Node node = list.item(0);
        String content = node.getTextContent();
        System.out.println(content);
    }

    @Test
    public void read2() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src\\book.xml");

        Node root = document.getElementsByTagName("world").item(0);
        list(root);

    }

    private void list(Node root) {
        /**
         * 只打印出节点名，空格和换行符（即 文本内容）不打印
         */
        if (root instanceof Element) {
            System.out.println(root.getNodeName());
        }
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            list(node);
        }

    }

    /**
     * 获得Element下的属性值
     * @throws Exception
     */
    @Test
    public void read3() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src\\book.xml");

        /**
         * 这是在我们知道取出来的Node是Element类型才能强转的。
         */
        Element element = (Element) document.getElementsByTagName("province").item(0);
        String attribute = element.getAttribute("name");
        System.out.println(attribute);

    }


    @Test
    public void update() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src\\book.xml"));

        /**
         * 创建新的元素
         */
        Element element = document.createElement("province");
        element.setTextContent("河北省");
        element.setAttribute("named", "yeqf");

        Element country = (Element) document.getElementsByTagName("country").item(0);
        country.appendChild(element);

        /**
         * 将内存里Document的更新同步到文件里
         */
        TransformerFactory trfactory = TransformerFactory.newInstance();
        Transformer transformer = trfactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src\\book.xml")));
    }

    /**
     * 将增加的element添加到指定位置
     * @throws Exception
     */
    @Test
    public void update2() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src\\book.xml"));

        /**
         * 创建新的元素
         */
        Element element = document.createElement("province");
        element.setTextContent("海南省");
        element.setAttribute("name", "huzi");

        /**
         * 添加到指定位置
         */
        //得到要挂载的节点
        Element country = (Element) document.getElementsByTagName("country").item(0);
        //得到参考节点
        Element refnode = (Element) document.getElementsByTagName("province").item(0);
        //挂载
        country.insertBefore(element, refnode);

        /**
         * 将内存里Document的更新同步到文件里
         */
        TransformerFactory trfactory = TransformerFactory.newInstance();
        Transformer transformer = trfactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src\\book.xml")));
    }

    @Test
    public void delete() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src\\book.xml");

        /**
         * 找到要删除的节点
         */
        Element del = (Element) document.getElementsByTagName("province").item(1);

        /**
         * 找到要删除的节点的父节点
         */
        //Element father = (Element) document.getElementsByTagName("country").item(0);
        Element father = (Element) del.getParentNode();

        //删除节点
        father.removeChild(del);

        TransformerFactory trfactory = TransformerFactory.newInstance();
        Transformer transformer = trfactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src\\book.xml")));
    }

}
