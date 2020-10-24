import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public interface Lib extends Library {
	@FieldOrder({"i1", "l1", "i2", "l2"})
	class S extends Structure {
		public S() {
		}

		public S(Pointer p) {
			super(p);
		}

		public int i1;
		public long l1;
		public volatile int i2;
		public volatile long l2;
	}

	class SAssigning extends S {
		public SAssigning() {
			i1 = 0x11223344;
			l1 = 0x1122334455667788L;
			i2 = 0x11223344;
			l2 = 0x1122334455667788L;
			writeField("i2");
			writeField("l2");
		}
	}

	void dump(S s);
	Pointer createS();
}
