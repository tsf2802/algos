public class ArraySet {

    private String[][] elements;
    private int size;

    public ArraySet() {
        elements = new String[10][];
        size = 0;
    }

    public void add(String[] array) {
        if (!contains(array)) {
            if (size == elements.length) {
                resize();
            }
            elements[size++] = createCopy(array);
        }
    }
    public boolean contains(String[] array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (arraysEqual(elements[i], array)) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        int newSize = elements.length * 2;
        String[][] newElements = new String[newSize][];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private String[] createCopy(String[] array) {
        String[] copy = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    private boolean arraysEqual(String[] array1, String[] array2) {
        
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }
}
