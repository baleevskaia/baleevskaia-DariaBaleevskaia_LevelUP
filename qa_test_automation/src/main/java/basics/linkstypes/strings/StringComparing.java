package basics.linkstypes.strings;

public class StringComparing {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";

        String aa = new String("dfe");
        String bb = new String("dfe");


// Собес: что выведется? == сравнивает не содержимое объектов, в их ссылки
        System.out.println("a == b" + (a == b)); //true - новый объект не создается,ссылка на область памяти одна и таже
        System.out.println("aa == bb" + (aa == bb)); // 2 разных объекта по ссылке не равны: false
        System.out.println("aa.equals(bb)" + (aa.equals(bb))); //equals сравнивает содержимое объектов: true

    }
}
