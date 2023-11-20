package Task2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class TapChi extends AnPham{
		String tenTapChi;
	
		public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String tenTapChi) {
			super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
			this.tenTapChi = tenTapChi;
		}
		
		public String getType() {
			return "Tap chi";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(tenTapChi);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			TapChi other = (TapChi) obj;
			return Objects.equals(tenTapChi, other.tenTapChi);
		}
		
		public boolean tapChiCachDay10Nam(){
			Calendar year= Calendar.getInstance();
			int yearDifferent= year.get(Calendar.YEAR)- namXuatBan;
			return (getType()== "Tap chi" && yearDifferent>=10);
		}
		
		public static boolean sameTypeAndAuthor(TapChi tc1, TapChi tc2) {
			return(tc1.getType().equals(tc2.getType()) && tc1.tacGia.equals(tc2.tacGia));
		}
		
		public static List<TapChi>	truoc1Nam(int year, List<TapChi> tc) {
			List<TapChi> re= new ArrayList<>();
			for (int i = 0; i < tc.size(); i++) {
				if (year- tc.get(i).namXuatBan==1) {
					re.add(tc.get(i));
				}
			}
			return re;
		}

		@Override
		public String toString() {
			return "TapChi [tenTapChi=" + tenTapChi + "]";
		}
}
