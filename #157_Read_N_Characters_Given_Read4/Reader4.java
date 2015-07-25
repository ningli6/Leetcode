public class Reader4 {
	public int read4(char[] buf) {
		if (buf == null) return 0;
		return (buf.length > 4) ? 4 : buf.length;
	}
}