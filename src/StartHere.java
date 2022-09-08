public class StartHere {
    public static void main(String[] args) {
        ListOfStrings list = new ListOfStrings();
        String test = "Testowy string nr 1";
        print(list);
        list.add(test);
        list.add("Pierwszy element");
        list.add(5,"Testujemy metode wstawiania pod indeks");
        list.add(1,"Testujemy metode wstawiania pod indeks");
        print(list);
        //list.clear();                          test passed
        //print(list);
        System.out.println(list.get(1));
        String[] list2 = {"Fill 1","Fill 2","Fill 3","Fill 4","Fill 5","Fill 6","Fill 7",};
        list.addAll(list2);                     //test passed
        //list.addAll(3,list2);
        list.remove("Fill 3");               //test passed
        print(list);
        list.set(1,"ELEMENT REPLACED");         //test passed
        print(list);
        if (list.contains(test)) System.out.println("element jest na liscie");
        else System.out.println("nie ma takiego elementu");
    }

    private static void print(ListOfStrings list) {
        System.out.println(list.toString());
    }
}
