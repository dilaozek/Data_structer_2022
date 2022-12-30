class Link {
	public long veri; // Düğüme gelecek olan veri
	public Link sonraki; // Listede sonraki düğüm
	public Link onceki; // Listede önceki düğüm
	// -------------------------------------------------------------

	public Link(long d) // Verinin standart geldiği yapılandırıcı
	{
		veri = d;
	}

	// -------------------------------------------------------------
	public void listele() // yazdırma fonksiyonu
	{
		System.out.print(veri + " ");
	}
	// -------------------------------------------------------------
} 

class IkiYonluListe {
	private Link ilk; // ilk veriyi tutan referans
	private Link son; // son veriyi tutan referans
	// -------------------------------------------------------------

	public IkiYonluListe() // Liste yapılandırıcısı
	{
		ilk = null; //  Listeyi boş olarak tanımlıyoruz.
		son = null;
	}

	// -------------------------------------------------------------
	public boolean bosMu() // Liste doluluk kontrolü
	{
		return ilk == null;
	}

	// -------------------------------------------------------------
	public void basaEkle(long dd) // Listenin başına ekleme fonksiyonu
	{
		Link yeniDugum = new Link(dd); // yeni düğüm oluşturuluyor

		if (bosMu()) // Listenin boşluk kontrolü
			son = yeniDugum;
		else
			ilk.onceki = yeniDugum; // Eski ilk ile yer değişiyor
		yeniDugum.sonraki = ilk; 
		ilk = yeniDugum; 
	}


	public void sonaEkle(long dd) // Listenin sonuna ekleme fonksiyonu
	{
		Link yeniDugum = new Link(dd); // yeni düğüm oluşturuyoruz.
		if (bosMu()) //Listenin boşluk kontrolü
			ilk = yeniDugum; 
		else {
			son.sonraki = yeniDugum; // son ile yeni düğüm yer değişiyor.
			yeniDugum.onceki = son;
		}
		son = yeniDugum; 
	}


	public Link bastanSil() // Baştaki veri silme fonksiyonu
	{
		Link yedek = ilk;
		if (ilk.sonraki == null) // Eğer sadece 1 veri varsa
			son = null; // sonuncuyu boşa çıkartıyoruz.
		else
			ilk.sonraki.onceki = null; 
		ilk = ilk.sonraki; 
		return yedek;
	}

	// -------------------------------------------------------------
	public Link sondanSil() // Sondan silme fonksiyonu
	{ 
		Link yedek = son;
		if (ilk.sonraki == null) // Eğer sadece 1 veri varsa
			ilk = null; // ilk veri boşa çıkıyor
		else
			son.onceki.sonraki = null;
		son = son.onceki;
		return yedek;
	}

	public boolean arkasinaEkle(long anahtar, long dd) { 
		Link aktif = ilk;
		while (aktif.veri != anahtar) // Eşleşme bulunana kadar
		{
			aktif = aktif.sonraki; // her seferinde döngü döndürüyoruz
			if (aktif == null)
				return false; // Bulunmayınca false dönüyor
		}
		Link yeniDugum = new Link(dd); // Yeni düğüm oluşturuyoruz

		if (aktif == son) // Eğer son veri ise
		{
			yeniDugum.sonraki = null; // yeni düğüm boşa çıkıyor
			son = yeniDugum;
		} else
		{
			yeniDugum.sonraki = aktif.sonraki; 
						
			aktif.sonraki.onceki = yeniDugum;
		}
		yeniDugum.onceki = aktif; 
		aktif.sonraki = yeniDugum; 
		return true; 
	}

	public Link seciliSil(long anahtar) // Seçili sıradaki elemanı silmek için kullanılan fonksiyon
	{ 
		Link aktif = ilk; 
		while (aktif.veri != anahtar) // Eşleşme bulana kadar
		{
			aktif = aktif.sonraki; // Döngü sürekli bir sonrakine aktarılıyor
			if (aktif == null)
				return null; // eşleşme bulunamadı
		}
		if (aktif == ilk) 
			ilk = aktif.sonraki; 
		else 
				
			aktif.onceki.sonraki = aktif.sonraki;

		if (aktif == son) 
			son = aktif.onceki; 
		else 
			
			aktif.sonraki.onceki = aktif.onceki;
		return aktif; // Bulunan değer döndürülüyor
	}

	public void yazdir() {
		System.out.print("Liste : ");
		Link aktif = ilk; 
		while (aktif != null) // Listenin sonuna kadar kontrol ediliyor
		{
			aktif.listele(); // Veri yazdırılıyor
			aktif = aktif.sonraki; // Döngü döndürülüyor
		}
		System.out.println("");
	}

} 
class LinkedList {
	public static void main(String[] args) { 
		IkiYonluListe liste = new IkiYonluListe();

		liste.basaEkle(22); //Başa ekleme yapıyoruz
		liste.basaEkle(44);
		liste.basaEkle(66);

		liste.sonaEkle(11); // Sona ekleme yapılıyor
		liste.sonaEkle(33);
		liste.sonaEkle(55);

		liste.yazdir(); //Ekrana yazdırılıyor

		liste.bastanSil(); // İlk veri siliniyor
		liste.sondanSil(); // Son veri siliniyor
		liste.seciliSil(11); // "11" etiketine sahip veri siliniyor

		liste.yazdir(); // Ekrana yazdırılıyor

		liste.arkasinaEkle(22, 77); // 22 ' den sonra 77 ekleniyor.
		liste.arkasinaEkle(33, 88); // 33'den sonra 88 ekleniyor.

		liste.yazdir(); // Ekrana yazdırılıyor
	} 
}