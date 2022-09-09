public class StartHere {
    public static void main(String[] args) {
        ListOfStrings list = new ListOfStrings();
        String test = "Testowy string nr 1";
        print(list);
        list.add(test);
        list.add("Pierwszy element");
        list.add(5,"Testujemy metode wstawiania pod innnndeks");
        list.clear();                          //test passed
        list.add(1,"Testujemy metode wstawiania pod indeksssss");
        print(list);
        System.out.println(list.get(1));
        String[] list2 = {"Fill 1","Fill 2","Fill 3"};
        String[] list3 = {"Fill 4","Fill 5","Fill 6"};
        ListOfStrings list4 = new ListOfStrings();
        list4.add("kolejny test");
        list4.addAll(list2);
        System.out.println(list.equals(list4));
        System.out.println("-------");
        print(list);
        list.addAll(list2);                    //test passed
        System.out.println(list.equals(list4));
        System.out.println("-------Dodawanie listy-------");
        print(list);
        System.out.println(list.size());
        list.addAll(1,list3);
        System.out.println("-------dodawanie listy po indeksie------");
        print(list);
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
