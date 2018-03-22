class demo {
	public static void main(String args[]) {
		try {
			int c = 1 / 0;
		} catch (MyOwnException e) {
			e.printStackTrace();
		}
		}
}