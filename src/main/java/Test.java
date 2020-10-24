import com.sun.jna.Native;

public class Test {
	public static void main(String[] args) {
		Lib lib = Native.load("lib", Lib.class);
		Lib.S s = new Lib.S();
		lib.dump(s);

		s.i1 = 0x12345678;
		s.l1 = 0x23456789ABCDEF01L;
		s.i2 = 0x34567890;
		s.l2 = 0x4567890ABCDEF012L;
		lib.dump(s);

		Lib.SAssigning sAssigning = new Lib.SAssigning();
		lib.dump(sAssigning);

		sAssigning.i1 = 0x12345678;
		sAssigning.l1 = 0x23456789ABCDEF01L;
		sAssigning.i2 = 0x34567890;
		sAssigning.l2 = 0x4567890ABCDEF012L;
		lib.dump(sAssigning);

		Lib.S cAllocatedS = new Lib.S(lib.createS());
		lib.dump(cAllocatedS);
	}
}
