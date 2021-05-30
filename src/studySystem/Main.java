package studySystem;

public class Main {

	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); //UIManager.getSystemLookAndFeelClassName());  // com.sun.java.swing.plaf.gtk.GTKLookAndFeel
////			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFrame.setDefaultLookAndFeelDecorated(true);
		
//		Course[] courses = new Course[3];
//		for(int i = 0; i < courses.length; i++) {
//			courses[i] = new Course("Course " + i);
//		}
		Course[] courses = null;
		
//		MainScreenFrame frame = new MainScreenFrame(courses);
		new MainPage();
	}

}
