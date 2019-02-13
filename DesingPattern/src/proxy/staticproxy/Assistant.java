package proxy.staticproxy;
/***
 * 
 * @author
 *         method need to be rewrited every time
 *
 */
public class Assistant implements Task {
	private Boss laoban;
	@Override
	public void meeting() {
		System.out.println("book");
		laoban.meeting();
		System.out.println("record");
	}

}
