import java.util.ArrayList;

public class arrayLst {
    public static void main(String[] args) {

// ArrayList - расширяемый массив

        ArrayList<String> list = new ArrayList<>(50);

        list.add("First element");
        list.add(1, "Second element");
        list.add(1, "Second element");

        String str = list.get(1);

        int dim = list.size();

        System.out.println(list);
        System.out.println(dim);
        System.out.println(list.indexOf("First element"));
        
    }
}
