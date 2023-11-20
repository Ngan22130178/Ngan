package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
		List<AnPham> dmAnPham;

		public DanhMucAnPham(List<AnPham> dmAnPham) {
			super();
			this.dmAnPham = dmAnPham;
		}
		
		public int totalPrice() {
			int price= 0;
			
			for (int i = 0; i < dmAnPham.size(); i++) {
				price+= dmAnPham.get(i).giaTien;
			}
			
			return price;
		}
		
		public  boolean coAnPham(String ten) {
			for (int i = 0; i <dmAnPham.size() ; i++) {
				if (ten== dmAnPham.get(i).tieuDe) {
					return true;
				}
			}
			return false;
		}
		
		
		public	 List<AnPham>  sort() {
			List<AnPham> sortedPublications = new ArrayList<>(dmAnPham);

	        // Sắp xếp tăng dần theo tiêu đề
	        Collections.sort(sortedPublications);

	        // Sắp xếp giảm dần theo năm xuất bản
	        Collections.sort(sortedPublications, AnPham.sortByYear);

	        return sortedPublications;
		}
		
		public Map<Integer, Integer> countPublicationsByYear() {
	        Map<Integer, Integer> publicationCountByYear = new HashMap<>();

	        // Đối với mỗi ấn phẩm, tăng số lượng cho năm tương ứng
	        for (AnPham publication : dmAnPham) {
	            int year = publication.namXuatBan;
	            publicationCountByYear.put(year, publicationCountByYear.getOrDefault(year, 0) + 1);
	        }

	        return publicationCountByYear;
	    }
}
