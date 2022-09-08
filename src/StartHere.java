public class StartHere {
    public static void main(String[] args) {
        ListOfStrings list = new ListOfStrings();
        String test1 = "To jest test 1";
        String test2 = "A to jest test 2";
        String[] test3 = {"To jest index 0 tablicy testowej","To jest index 1 tablicy testowej"};
        print(list);
        list.add(test1);
        print(list);
        list.addAll(test3);
        print(list);
        list.remove("st1");
        print(list);
        list.remove(test1);
        print(list);
        list.addAll(2, test3);
        print(list);
        String[] tablica = list.toArray();
        for (String e : tablica) System.out.println(e + " ");
        print(list);
        list.clear();
        print(list);
        System.out.println("-----");
        list.add(test2);
        list.add(0,test2);
        list.add(2, test1);
        print(list);
        System.out.println("--------");
        list.addAll(1,test3);
        list.addAll(test3);
        print(list);
        System.out.println(list.get(2));
        if (list.contains(test2)) System.out.println("element jest na liscie");
        else System.out.println("nie ma takiego elementu");
    }

    private static void print(ListOfStrings list) {
        System.out.println("Zawartosc listy " + list.toString());
    }
}
