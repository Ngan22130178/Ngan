package Task2;

import java.util.List;
import java.util.Objects;

public class SachThamKhao extends AnPham{
		String linhVuc;
		List<ChuongSach> dsChuongSach;
		
		public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String linhVuc,
				List<ChuongSach> dsChuongSach) {
			super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
			this.linhVuc = linhVuc;
			this.dsChuongSach = dsChuongSach;
		}
		
		public String getType() {
			return "Sach tham khao";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(dsChuongSach, linhVuc);
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
			SachThamKhao other = (SachThamKhao) obj;
			return Objects.equals(dsChuongSach, other.dsChuongSach) && Objects.equals(linhVuc, other.linhVuc);
		}
		public static boolean sameTypeAndAuthor(SachThamKhao tk1, SachThamKhao tk2) {
			return(tk1.getType().equals(tk2.getType()) && tk1.tacGia.equals(tk2.tacGia));
		}
		
		public static  void nhieuTrangNhat(List<SachThamKhao> stk) {
			int tmp= 0;
			for (int i = 0; i <stk.size()-1; i++) {
				if (stk.get(i).soTrang>stk.get(i+1).soTrang) {
					tmp=i;
				}
				tmp= i+1;
			}
			System.out.println(stk.get(tmp).toString());
		}

		@Override
		public String toString() {
			return "SachThamKhao [linhVuc=" + linhVuc + ", dsChuongSach=" + dsChuongSach + "]";
		}
}
