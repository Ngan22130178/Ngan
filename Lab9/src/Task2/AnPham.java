package Task2;

import java.util.Comparator;
import java.util.Objects;

public class AnPham  implements Comparable<AnPham> {
		protected String tieuDe;
		protected int soTrang, namXuatBan;
		protected String tacGia;
		protected int giaTien;
		
		public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien) {
			super();
			this.tieuDe = tieuDe;
			this.soTrang = soTrang;
			this.namXuatBan = namXuatBan;
			this.tacGia = tacGia;
			this.giaTien = giaTien;
		}
		
		
		
		@Override
		public int hashCode() {
			return Objects.hash(giaTien, namXuatBan, soTrang, tacGia, tieuDe);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AnPham other = (AnPham) obj;
			return giaTien == other.giaTien && namXuatBan == other.namXuatBan && soTrang == other.soTrang
					&& Objects.equals(tacGia, other.tacGia) && Objects.equals(tieuDe, other.tieuDe);
		}
		
		public static boolean sameTypeAndAuthor(SachThamKhao tk, TapChi tc) {
			return false;
		}
		
		public static boolean sameTypeAndAuthor(TapChi tc, SachThamKhao tk) {
			return false;
		}

		@Override
		public int compareTo(AnPham o) {
			return this.tieuDe.compareTo(o.tieuDe);
		}

		public static Comparator<AnPham> sortByYear= new Comparator<AnPham>() {
			
			@Override
			public int compare(AnPham o1, AnPham o2) {
				return Integer.compare(o1.namXuatBan, o2.namXuatBan);
			}
		};  
		
}
