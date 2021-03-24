// Tamsayı elemanlarını tutan yığıt sınıfı. 
import java.util.Scanner;
class Stack {
	// Yığıtın alabileceği eleman sayısının üst sınırı. 
	public final int MAX_SIZE = 100;
	private int top;
	private int[] elements;

	// Yığıt yaratıcı işlev.
	public Stack() {
		top = -1;
		elements = new int[MAX_SIZE]; // diziyi yarat
	}

	// full() işlevi, yığıt dolu ise true, değilse false döner. 
	public boolean full() {
		return (top == MAX_SIZE-1); 
	}

	// empty() işlevi, yığıt boş ise true, değilse false döner. 
	public boolean empty() {
		return (top == -1); 
	}

	// push(x) işlevi, yığıt dolu ise hata verir, değilse verilen x değerini yığıta ekler. 
	public void push(int x) {
		if (full()) throw new RuntimeException("Hata: Yigit dolu"); // yığıt doluysa hata ver
		++top; // eleman sayısını artır
		elements[top] = x; // yığıtın üzerine x'i ekle
	}

	// pop() işlevi, yığıt boş ise hata verir, değilse yığıtın en üst elemanını alıp döndürür. 
	public int pop() {
		if (empty()) throw new RuntimeException("Hata: Yigit bos"); // yığıt boşsa hata ver
		int temp = elements[top]; // üstteki elemanı al
		top--; // eleman sayısını azalt
		return temp; // daha önce üstte olan elemanı döndür
	}

	public static boolean asalmi(int number){
       
		if (number < 2)
			return false;	
		for (int i = 2; i <= number/2; i++){
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public static void yazdir(Stack yigit){
		while(!yigit.empty())   // yığıtta sayı olduğu sürece, al ve yaz
			System.out.println(yigit.pop());
	}

	static void hesapla(){

		Stack prime = new Stack();
		Stack noprime = new Stack();
		Stack temp = new Stack();

		int i;
		Scanner oku = new Scanner(System.in);

		do {     // sayıları oku ve yığıta ekle

			i = oku.nextInt();
			if(i>=0) {
				if (asalmi(i))
					prime.push(i);
				else 
					noprime.push(i);
			}
			
		} while(i>=0);      // negatif olduğunda çık


		while(!prime.empty())   // yığıtı ters çevir
			temp.push(prime.pop());

		System.out.println("Asal Sayilar:");
		yazdir(temp);

		System.out.println("\nAsal olmayan Sayilar:");
		yazdir(noprime);
    
	}

	public static void main(String[] args) {

		hesapla();
        
	}
}

