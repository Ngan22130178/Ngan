package Task2;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		TapChi tc1= new TapChi("A", 120, 1990, "Nguyen A", 56000, "TC A");
		TapChi tc2= new TapChi("A1", 100, 2013, "Nguyen A", 50000, "TC A1");
		TapChi tc3= new TapChi("B", 100, 1999, "Nguyen B", 51000, "TC A2");
		
		ChuongSach cs1= new ChuongSach("AV1", 150);
		ChuongSach cs2= new ChuongSach("AV2", 150);
		List<ChuongSach> csAV= new ArrayList<>();
		csAV.add(cs1);
		csAV.add(cs2);
		SachThamKhao tk1= new SachThamKhao("D", 300, 2000, "Nguyen B", 98000, "AV", csAV);
		
		ChuongSach cs3= new ChuongSach("NV1", 100);
		ChuongSach cs4= new ChuongSach("NV2", 100);
		List<ChuongSach> csNV= new ArrayList<>();
		csNV.add(cs3);
		csNV.add(cs4);
		SachThamKhao tk2= new SachThamKhao("E", 200, 2001, "Nguyen V", 60000, "NV", csNV);
		
		ChuongSach cs5= new ChuongSach("NV1", 100);
		ChuongSach cs6= new ChuongSach("NV2", 100);
		List<ChuongSach> csNV2= new ArrayList<>();
		csNV2.add(cs5);
		csNV2.add(cs6);
		SachThamKhao tk3= new SachThamKhao("C", 200, 2001, "Nguyen B", 60000, "NV", csNV);
		
		//System.out.println(tc1.tapChiCachDay10Nam());
		//System.out.println(tc2.tapChiCachDay10Nam());
		//System.out.println(TapChi.sameTypeAndAuthor(tc1, tc2));
		//System.out.println(TapChi.sameTypeAndAuthor(tc1, tc3));
		//System.out.println(AnPham.sameTypeAndAuthor(tc1, tk2));
		//System.out.println(SachThamKhao.sameTypeAndAuthor(tk1, tk2));
		//System.out.println(SachThamKhao.sameTypeAndAuthor(tk1, tk3));
		List<AnPham> dmAnPham= new ArrayList<>();
		dmAnPham.add(tk3);
		dmAnPham.add(tk2);
		dmAnPham.add(tk1);
		dmAnPham.add(tc3);
		dmAnPham.add(tc2);
		dmAnPham.add(tc1);
		
		DanhMucAnPham dm1= new DanhMucAnPham(dmAnPham);
		//System.out.println(dm1.totalPrice());
		//System.out.println(dm1.sort());
		System.out.println(dm1.countPublicationsByYear());
		List<SachThamKhao> stk= new ArrayList<>();
		stk.add(tk3);
		stk.add(tk2);
		stk.add(tk1);
		//SachThamKhao.nhieuTrangNhat(stk);
		
		//System.out.println(dm1.coAnPham("F"));
		
		TapChi tc4= new TapChi("T", 100, 1999, "Nguyen C", 51000, "TC A3");
		List<TapChi> tc= new ArrayList<>();
		tc.add(tc4);
		tc.add(tc3);
		tc.add(tc2);
		tc.add(tc1);
		//System.out.println(TapChi.truoc1Nam(2000, tc));
		
	}
}
