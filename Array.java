package com.ArraysDSA;

// Creating a Array class
public class Array {
    private int [] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void printAll() {

        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }

    }

    // insert method
    public void insert(int item) {
        // If the array is full, resize it
        resize();
        //Add the new item to the end
        items[count++] = item;
        // count ++;
    }

    public void resize(){
        if (items.length == count) {
        //1. Create a new array (twice size)
        int [] newArray = new int[count * 2];
        //2. Copy all the items
        for (int i=0;i<count ;i++ )
            newArray[i] = items[i];
        //3. Ser "items" to this new array
        items = newArray;
        }
    }

    // removeAt method
    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++ ) {
            items[i] = items[i+1];
        }

        count--;
    }

    // indexOf method
    public int indexOf(int item) {
        for (int i = 0; i < items.length - 1; i++) {
            if (item == items[i]) {
                return i;
            }
        }
        return -1;
    }

    public int max(){
        int maxNum = 0;
        for(int item: items)
            if(item > maxNum)
                maxNum = item;
        return maxNum;
    }


    public Array intersect(Array anotherArray){
        var intersection =  new Array(count);
        for(var item: items){
            if (anotherArray.indexOf(item) >= 0) {
                intersection.insert(item);
            }
        }
        return intersection;
    }

    public void reverse(){
        Array reversedArray = new Array(count);
        for (int i = count-1;i >= 0 ;i-- ) {
            reversedArray.insert(items[i]);
        }
        reversedArray.printAll();
    }

    public void insertAt(int item, int index){
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }

        resize();
        for (int i = count-1;i >= index; i-- ){
            items[i + 1] = items[i];
        }

        items[index] = item;
        count++;
    }

}
