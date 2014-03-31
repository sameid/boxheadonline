
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filter extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
		return true;
		}

		String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
		
		if (ext != null) {
			if (ext.equals("jpg")) {
				System.out.println("Check");
				return true;
			}
			else if (ext.equals("png")) {
				System.out.println("Check");
				return true;
			}
			else if (ext.equals("gif")) {
				System.out.println("Check");
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Pic Files";
	}
	
	

}
