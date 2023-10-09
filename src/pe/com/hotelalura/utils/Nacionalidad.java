package pe.com.hotelalura.utils;

public enum Nacionalidad {
	afgano_afgana("afgano - afgana"), 
	alem�n_alemana("alem�n - alemana"), 
	�rabe_�rabe("�rabe - �rabe"), 
	argentino_argentina("argentino - argentina"), 
	australiano_australiana("australiano - australiana"), 
	belga_belga("belga - belga"), 
	boliviano_boliviana("boliviano - boliviana"), 
	brasile�o_brasile�a("brasile�o - brasile�a"), 
	camboyano_camboyana("camboyano - camboyana"), 
	canadiense_canadiense("canadiense - canadiense"), 
	chileno_chilena("chileno - chilena"), 
	chino_china("chino - china"), 
	colombiano_colombiana("colombiano - colombiana"), 
	coreano_coreana("coreano - coreana"), 
	costarricense_costarricense("costarricense - costarricense"), 
	cubano_cubana("cubano - cubana"), 
	dan�s_danesa("dan�s - danesa"), 
	ecuatoriano_ecuatoriana("ecuatoriano - ecuatoriana"), 
	egipcio_egipcia("egipcio - egipcia"), 
	salvadore�o_salvadore�a("salvadore�o - salvadore�a"), 
	escoc�s_escocesa("escoc�s - escocesa"), 
	espa�ol_espa�ola("espa�ol - espa�ola"), 
	estadounidense_estadounidense("estadounidense - estadounidense"), 
	estonio_estonia("estonio - estonia"), 
	etiope_etiope("etiope - etiope"), 
	filipino_filipina("filipino - filipina"), 
	finland�s_finlandesa("finland�s - finlandesa"), 
	franc�s_francesa("franc�s - francesa"), 
	gal�s_galesa("gal�s - galesa"), 
	griego_griega("griego - griega"), 
	guatemalteco_guatemalteca("guatemalteco - guatemalteca"), 
	haitiano_haitiana("haitiano - haitiana"), 
	holand�s_holandesa("holand�s - holandesa"), 
	hondure�o_hondure�a("hondure�o - hondure�a"), 
	indon�s_indonesa("indon�s - indonesa"), 
	ingl�s_inglesa("ingl�s - inglesa"), 
	iraqu�_iraqu�("iraqu� - iraqu�"), 
	iran�_iran�("iran� - iran�"), 
	irland�s_irlandesa("irland�s - irlandesa"), 
	israel�_israel�("israel� - israel�"), 
	italiano_italiana("italiano - italiana"), 
	japon�s_japonesa("japon�s - japonesa"), 
	jordano_jordana("jordano - jordana"), 
	laosiano_laosiana("laosiano - laosiana"), 
	let�n_letona("let�n - letona"), 
	leton�s_letonesa("leton�s - letonesa"), 
	malayo_malaya("malayo - malaya"), 
	marroqu�_marroqu�("marroqu� - marroqu�"), 
	mexicano_mexicana("mexicano - mexicana"), 
	nicarag�ense_nicarag�ense("nicarag�ense - nicarag�ense"), 
	noruego_noruega("noruego - noruega"), 
	neozeland�s_neozelandesa("neozeland�s - neozelandesa"), 
	paname�o_paname�a("paname�o - paname�a"), 
	paraguayo_paraguaya("paraguayo - paraguaya"), 
	peruano_peruana("peruano - peruana"), 
	polaco_polaca("polaco - polaca"), 
	portugu�s_portuguesa("portugu�s - portuguesa"), 
	puertorrique�o_puertorrique�o("puertorrique�o - puertorrique�o"), 
	dominicano_dominicana("dominicano - dominicana"), 
	rumano_rumana("rumano - rumana"), 
	ruso_rusa("ruso - rusa"), 
	sueco_sueca("sueco - sueca"), 
	suizo_suiza("suizo - suiza"), 
	tailand�s_tailandesa("tailand�s - tailandesa"), 
	taiwanes_taiwanesa("taiwanes - taiwanesa"), 
	turco_turca("turco - turca"), 
	ucraniano_ucraniana("ucraniano - ucraniana"), 
	uruguayo_uruguaya("uruguayo - uruguaya"), 
	venezolano_venezolana("venezolano - venezolana"), 
	vietnamita_vietnamita("vietnamita - vietnamita");
	
	private String name;

    Nacionalidad(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
    	return name;
    }
}
