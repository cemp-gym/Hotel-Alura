package pe.com.hotelalura.utils;

public enum Nacionalidad {
	afgano_afgana("afgano - afgana"), 
	alemán_alemana("alemán - alemana"), 
	árabe_árabe("árabe - árabe"), 
	argentino_argentina("argentino - argentina"), 
	australiano_australiana("australiano - australiana"), 
	belga_belga("belga - belga"), 
	boliviano_boliviana("boliviano - boliviana"), 
	brasileño_brasileña("brasileño - brasileña"), 
	camboyano_camboyana("camboyano - camboyana"), 
	canadiense_canadiense("canadiense - canadiense"), 
	chileno_chilena("chileno - chilena"), 
	chino_china("chino - china"), 
	colombiano_colombiana("colombiano - colombiana"), 
	coreano_coreana("coreano - coreana"), 
	costarricense_costarricense("costarricense - costarricense"), 
	cubano_cubana("cubano - cubana"), 
	danés_danesa("danés - danesa"), 
	ecuatoriano_ecuatoriana("ecuatoriano - ecuatoriana"), 
	egipcio_egipcia("egipcio - egipcia"), 
	salvadoreño_salvadoreña("salvadoreño - salvadoreña"), 
	escocés_escocesa("escocés - escocesa"), 
	español_española("español - española"), 
	estadounidense_estadounidense("estadounidense - estadounidense"), 
	estonio_estonia("estonio - estonia"), 
	etiope_etiope("etiope - etiope"), 
	filipino_filipina("filipino - filipina"), 
	finlandés_finlandesa("finlandés - finlandesa"), 
	francés_francesa("francés - francesa"), 
	galés_galesa("galés - galesa"), 
	griego_griega("griego - griega"), 
	guatemalteco_guatemalteca("guatemalteco - guatemalteca"), 
	haitiano_haitiana("haitiano - haitiana"), 
	holandés_holandesa("holandés - holandesa"), 
	hondureño_hondureña("hondureño - hondureña"), 
	indonés_indonesa("indonés - indonesa"), 
	inglés_inglesa("inglés - inglesa"), 
	iraquí_iraquí("iraquí - iraquí"), 
	iraní_iraní("iraní - iraní"), 
	irlandés_irlandesa("irlandés - irlandesa"), 
	israelí_israelí("israelí - israelí"), 
	italiano_italiana("italiano - italiana"), 
	japonés_japonesa("japonés - japonesa"), 
	jordano_jordana("jordano - jordana"), 
	laosiano_laosiana("laosiano - laosiana"), 
	letón_letona("letón - letona"), 
	letonés_letonesa("letonés - letonesa"), 
	malayo_malaya("malayo - malaya"), 
	marroquí_marroquí("marroquí - marroquí"), 
	mexicano_mexicana("mexicano - mexicana"), 
	nicaragüense_nicaragüense("nicaragüense - nicaragüense"), 
	noruego_noruega("noruego - noruega"), 
	neozelandés_neozelandesa("neozelandés - neozelandesa"), 
	panameño_panameña("panameño - panameña"), 
	paraguayo_paraguaya("paraguayo - paraguaya"), 
	peruano_peruana("peruano - peruana"), 
	polaco_polaca("polaco - polaca"), 
	portugués_portuguesa("portugués - portuguesa"), 
	puertorriqueño_puertorriqueño("puertorriqueño - puertorriqueño"), 
	dominicano_dominicana("dominicano - dominicana"), 
	rumano_rumana("rumano - rumana"), 
	ruso_rusa("ruso - rusa"), 
	sueco_sueca("sueco - sueca"), 
	suizo_suiza("suizo - suiza"), 
	tailandés_tailandesa("tailandés - tailandesa"), 
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
