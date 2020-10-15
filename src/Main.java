
public class Main {

	public static void main(String[] args) {
		List<Integer> myList = new List<Integer>();
		myList.pushBack(1);
		myList.pushBack(2);
		myList.pushBack(3);
		myList.pushBack(2);
		myList.pushBack(1);;
		
		List<Integer>.Iterator it = myList.begin();
		for(int i = 0; i < myList.size(); i++){
			System.out.println(it.get());
			it.next();
		}
		
		System.out.println("==============");
		it = myList.begin();
		for(int i = 0; i < myList.size()-2; i++){
			it.next();
		}
		myList.erase(it);
		
		it = myList.begin();
		while(!it.equals(myList.end())){
			System.out.println(it.get());
			it.next();
		}
		
		System.out.println("==============");
		List<String> strList = new List<String>();
		strList.pushFront("ty");
		strList.pushFront("er");
		strList.pushFront("qw");
		for(int i = 0; i < strList.size(); i++){
			System.out.print(strList.getByIndex(i));
		}
	}

}
