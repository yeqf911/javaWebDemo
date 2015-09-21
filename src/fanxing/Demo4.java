package fanxing;

/**
 * Created by yeqf on 2015/9/21.
 */
public class Demo4 {

    /**
     * 编写一个泛型方法，是指定位置上的数组元素的交换
     */
    public <T> void swap(T array[], int pos1, int pos2) {
        T temp;
        temp = array[pos2];
        array[pos2] = array[pos1];
        array[pos1] = temp;
    }


    /**
     * 编写一个泛型方法，颠倒一个数组里的所有元素位置
     * @param arr
     * @param <T>
     */
    public <T> void swapAll(T arr[]) {

        int start = 0;
        int end = arr.length;

        while (start < end) {
            T temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
