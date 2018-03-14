public class Main {
    public static void main(String[] args) {
        System.out.print("A");
        Helper.sayB();
        Helper.sayC();
    }
}

// class Helper {
//     public static void sayB() {
//         System.out.print("B");
//     }
// 
//     public static void sayC() {
//         System.out.print("C");
//         // bad bytecode goes here
//     }
// }
