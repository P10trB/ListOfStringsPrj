import java.util.Arrays;

public class ListOfStrings {
    private String[] string = null;
    private int idx = -1;

    public int size() {
        if(listNotEmpty()) return string.length;
        return 0;
    }
    public boolean contains(String o) {
        if (listNotEmpty()) {
            for (int i = 0; i < string.length; i++)
                if (o.equals(string[i])){
                    idx = i;
                    return true;
                }
        } else {
            idx = -1;
        }
        return false;
    }
    public void add(String o) {
        if (listNotEmpty()) {
            String[] tmpArray = new String[string.length + 1];
            System.arraycopy(string, 0, tmpArray, 0, string.length);
            tmpArray[string.length] = o;
            string = tmpArray;
        } else {
            string = new String[1];
            string[0] = o;
        }
    }
    public void add(int index, String element){         //prawdopodobnie naprawione w koncu
        String[] tmpArray;
        if ((listNotEmpty()) && (!outOfBounds(index))) {
            tmpArray = new String[string.length + 1];
            int tempIndex = 0;
            for(int i = 0; i < tmpArray.length; i++){
                if(i == index) {
                    tmpArray[i] = element;
                }
                else{
                    tmpArray[i] = string[tempIndex];
                    tempIndex++;
                }
            }
            string = tmpArray;
        }
        else if(!listNotEmpty()){
            System.out.println("The list was empty, cannot add at specified index, adding first element to the list.");
            string = new String[1];
            string[0] = element;
        }
    }

    private boolean outOfBounds(int index) {
        if(listNotEmpty()) {
            if (index >= string.length || index < 0) {           //check if index out of bounds
                System.out.printf("Index %d is out of bounds!\n", index);
                return true;
            }
        }
        return false;
    }

    public void addAll(String[] list){
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
    }
    private boolean listNotEmpty(){
        return string != null;
    }
    public void addAll(int cIndex, String[] c){
        String[] tmpArr;
        if(outOfBounds(cIndex)){
            return;
        }
        if ((listNotEmpty()) && (!outOfBounds(cIndex)))  {
            tmpArr = new String[string.length + c.length];
            int stringIndex = 0;
            for (int i = 0; i < tmpArr.length; i++) {
                    if(cIndex == i){
                        for (int j = 0; j < c.length; j++,i++) {
                            tmpArr[i] = c[j];
                        }
                    }
                    tmpArr[i] = string[stringIndex++];
            }
            string = tmpArr;
        }
        else if(!listNotEmpty()){
            System.out.println("The list was empty, adding new list.");
            string = c;
        }
    }       //w trakcie naprawiania
    public void remove(String o) {
        if (string == null) {
            System.out.println("List is empty.");
            return;
        }
        boolean exists = false;
        idx = -1;
        for (int i = 0; i < string.length; i++) {   //Find first occurrence of specified element.
            if (string[i].equals(o)) {
                exists = true;                      //if found set this boolean value to true.
                idx = i;                            //and set variable idx to the index of found element.
                break;
            }
        }
        if (!exists) {
            System.out.println("List doesn't contain specified element.");
        } else {
            String[] tmpArr = new String[string.length - 1];
            int tmpIndex = 0;
            for (String el : string)
                if (!el.equals(o)) {
                    tmpArr[tmpIndex] = el;
                    tmpIndex++;
                }
            string = tmpArr;
        }
    }       //naprawione
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
    public void set(int index, String element){
        string[index] = element;
    }

    @Override
    public String toString() {
        return "The list contains:{" + Arrays.toString(string) +
                '}';
    }
}
