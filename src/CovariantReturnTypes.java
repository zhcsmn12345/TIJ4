//: generics/CovariantReturnTypes.java

class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
  Base get();
}

interface DerivedGetter extends OrdinaryGetter {
  // Return type of overridden method is allowed to vary:
  Derived get();
}
class OrdinaryGetterImpl implements OrdinaryGetter{
	public Base get() {
		return new Derived();
	}
}

class DerivedGetterImpl implements DerivedGetter{
	public Derived get() {
		return new Derived();
	}
}

public class CovariantReturnTypes {
  void test(OrdinaryGetter d) {
    Base d2 = d.get();
    System.out.println(d2);
  }
  public static void main(String[] args) {
	new CovariantReturnTypes().test(new DerivedGetterImpl());
	new CovariantReturnTypes().test(new OrdinaryGetterImpl());
  }
} ///:~
