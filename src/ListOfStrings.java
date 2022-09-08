import java.util.Arrays;

public class ListOfStrings {
    private String[] string = null;
    private int idx = -1;

    public int size() {
        return string.length;
    }
    public boolean isEmpty() {
        return string.length == 0;
    }
    public boolean contains(String o) {
        if (string.length > 0) {
            for (int i = 0; i < string.length; i++)
                if (o.equals(string[i])){
                    idx = i;
                    return true;
                }
        } else {
            System.out.println("Lista jest pusta");
            idx = -1;
        }
        return false;
    }
    public boolean add(String o) {
        if (string != null) {
            String[] tmpArray = new String[string.length + 1];
            for (int i = 0; i < string.length; i++)
                tmpArray[i] = string[i];
            tmpArray[string.length + 1] = o;
            string = tmpArray;
        } else {
            string = new String[1];
            string[0] = o;
        }
        return true;
    }
    public void add(int index, String element){
        if (string != null) {
            String[] tmpArray = new String[string.length + 1];
            int tmp = 0;
            for(int i = 0; i < string.length; i++){
                if(i == index) {
                    tmpArray[tmp] = element;
                    tmp++;
                }
                else
                    tmpArray[tmp] = string[i];
                tmp++;
            }
        }
        else if(index > 0){
            System.out.println("The list was empty, cannot add at specified index, adding first element to the list.");
            string = new String[1];
            string[0] = element;
        }
    }
    public boolean addAll(String[] list){
        String[] tmpArr = new String[string.length + list.length];
        int index = 0;
        for(String el : string){
            tmpArr[index] = el;
            index++;
        }
        for(String el : list){
            tmpArr[index] = el;
            index++;
        }
        string = tmpArr;
        return true;
    }
    public boolean addAll(int index, String[] c){
        int tmp1,tmp2;
        tmp1 = tmp2 = 0;
        if (string != null) {
            String[] tmpArr = new String[string.length + c.length];
            for(int i = 0; i < string.length; i++){
                if(i >= index && i < c.length){
                    tmpArr[tmp1] = c[tmp2];
                    tmp1++;
                    tmp2++;
                }
                else{
                    tmpArr[tmp1] = string[i];
                    tmp1++;
                }
            }
            string = tmpArr;
        }
        else if(index > 0){
            System.out.println("The list was empty, cannot add at specified index, adding new elements to the list.");
        }
        string = c;
        return true;
    }
    public boolean remove(String o) {
        if (string == null) {
            System.out.println("List is empty.");
            return false;
        }
        boolean exists = false;
        idx = -1;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == o) exists = true;
            idx = i;
            break;
        }
        if (!exists) {
            System.out.println("List doesn't contain specified element.");
            return false;
        } else {
            //zrob nowy array i usun to dziadostwo
            String[] tmpArr = new String[string.length - 1];
            int tmpIndex = 0;
            for (String el : string)
                if (el != o) {
                    tmpArr[tmpIndex] = el;
                    tmpIndex++;
                }
            return true;
        }
    }
    public void clear() {
        string = null;
    }
    public boolean equals(ListOfStrings o){
        return this == o;
    }
    public String get(int index){
        if(string != null && index < string.length)
        return string[index];
        else{
            System.out.println("Lista jest pusta!");
            return null;
        }
    }
    public int indexOf(String o){
        if(contains(o)) return idx;
        return -1;
    }
    public String set(int index, String element){
        string[index] = element;
        return element;
    }
    public String[] toArray(){
        return string;
    }

    @Override
    public String toString() {
        return "ListOfStrings{" +
                "string=" + Arrays.toString(string) +
                '}';
    }
}
