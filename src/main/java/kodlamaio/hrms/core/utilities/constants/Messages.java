package kodlamaio.hrms.core.utilities.constants;

public class Messages {
	
	//User
    public static String userListed = "kullanıcılar listelendi.";
    public static String userAdded = "kullanıcı eklendi.";
    public static String userDeleted = "Kullanıcı silindi.";
    public static String userUpdated = "Kullanıcı güncellendi.";
    
    //General
    public static String notNull = "Alanlar boş bırakılamaz";
    public static String emailExist = "Bu email zaten mevcut";
    public static String passwordNotConfirmed = "Parolalar uyuşmuyor";
    
    //Employer
    public static String domainNotEqual="E-posta ile web sitenin domaini eşleşmiyor";
    public static String activationCodeNotFound = "Doğrulama kodu bulunamadı";
    public static String alreadyConfirmed = "Email doğrulanmış";
    public static String codeExpired = "Kodun zamanı geçmiş lütfen yenisini oluşturun";
    public static String codeNotEqual= "Kod uyuşmuyor";
    public static String codeConfirmed = "Email doğrulandı";
    public static String userNotFound = "kullanıcı bulunamadı";
    
    //JobSeeker
    public static String personInValid = "Kişi doğrulaması başarısız....";
    public static String nationalIdentityExist = "Bu kimlik numarasız zaten mevcut";
    public static String nationalIdNotValid = "Geçerli bir TC giriniz";
    
    //JobPositions
    public static String titleEquals = "Bu pozisyon zaten var";
    public static String jobPositionAdded = "İş bölümü eklendi";
    public static String jobPositionListed = "İş bölümleri listelendi";
}
