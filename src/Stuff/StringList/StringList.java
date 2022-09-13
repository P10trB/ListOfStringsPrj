package Stuff.StringList;

import java.util.Arrays;
public class StringList {
    private String[] listOfStrings = null;

    public int size() {
        return listNotEmpty() ? listOfStrings.length : 0;
    }
    public boolean contains(String o) {
        if (listNotEmpty()) {
            for (String s : listOfStrings)
                if (o.equals(s)){
                    return true;
                }
        }
        return false;
    }
    public void add(String o) {
        if (listNotEmpty()) {
            String[] tmpArray = new String[listOfStrings.length + 1];
            System.arraycopy(listOfStrings, 0, tmpArray, 0, listOfStrings.length);
            tmpArray[listOfStrings.length] = o;
            listOfStrings = tmpArray;
        } else {
            listOfStrings = new String[1];
            listOfStrings[0] = o;
        }
    }
    public void add(int indexOfElementToBeAdded, String elementToBeAdded){
        String[] tmpArray;
        if ((listNotEmpty()) && (!outOfBounds(indexOfElementToBeAdded))) {
            tmpArray = new String[listOfStrings.length + 1];
            int tempIndex = 0;
            for(int i = 0; i < tmpArray.length; i++){
                if(i == indexOfElementToBeAdded) {
                    tmpArray[i] = elementToBeAdded;
                }
                else{
                    tmpArray[i] = listOfStrings[tempIndex];
                    tempIndex++;
                }
            }
            listOfStrings = tmpArray;
        }
        else if(!listNotEmpty()){
            System.out.println("The list was empty, cannot add at specified index, adding first element to the list.");
            listOfStrings = new String[1];
            listOfStrings[0] = elementToBeAdded;
        }
    }

    private boolean outOfBounds(int index) {
        if(listNotEmpty()) {
            if (index >= listOfStrings.length || index < 0) {           //check if index out of bounds
                System.out.printf("Index %d is out of bounds!\n", index);
                return true;
            }
        }
        return false;
    }

    public void addAll(String[] list){
        String[] tmpArr = new String[listOfStrings.length + list.length];
        int index = 0;
        for(String el : listOfStrings){
            tmpArr[index] = el;
            index++;
        }
        for(String el : list){
            tmpArr[index] = el;
            index++;
        }
        listOfStrings = tmpArr;
    }
    private boolean listNotEmpty(){
        return listOfStrings != null;
    }
    public void addAll(int cIndex, String[] c){
        String[] tmpArr;
        if(outOfBounds(cIndex)){
            return;
        }
        if ((listNotEmpty()) && (!outOfBounds(cIndex)))  {
            tmpArr = new String[listOfStrings.length + c.length];
            int stringIndex = 0;
            for (int i = 0; i < tmpArr.length; i++) {
                if(cIndex == i){
                    for (int j = 0; j < c.length; j++,i++) {
                        tmpArr[i] = c[j];
                    }
                }
                tmpArr[i] = listOfStrings[stringIndex++];
            }
            listOfStrings = tmpArr;
        }
        else if(!listNotEmpty()){
            System.out.println("The list was empty, adding new list.");
            listOfStrings = c;
        }
    }
    public void remove(String o) {
        if (!listNotEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        boolean exists = false;
        for (String s : listOfStrings) {   //Find first occurrence of specified element.
            if (s.equals(o)) {
                exists = true;                          //and set variable idx to the index of found element.
                break;
            }
        }
        if (!exists) {
            System.out.println("List doesn't contain specified element.");
        } else {
            String[] tmpArr = new String[listOfStrings.length - 1];
            int tmpIndex = 0;
            for (String el : listOfStrings)
                if (!el.equals(o)) {
                    tmpArr[tmpIndex] = el;
                    tmpIndex++;
                }
            listOfStrings = tmpArr;
        }
    }
    public void clear() {
        listOfStrings = null;
    }
    public boolean equals(StringList o){
        return this == o;
    }
    public String get(int index){
        if(listOfStrings != null && index < listOfStrings.length)
            return listOfStrings[index];
        else{
            System.out.println("Lista jest pusta!");
            return null;
        }
    }
    public void set(int index, String element){
        listOfStrings[index] = element;
    }

    @Override
    public String toString() {
        return "The list contains:{" + Arrays.toString(listOfStrings) +
                '}';
    }
}
