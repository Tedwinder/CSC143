//<hw> tags the headword
//<pr>          pronunciation
//<pos>         part of speech
//<ety>         etymology
//<ets>         "source" word within an <ety> field, usually foreign words
//<fld>         field of knowledge (e.g. Med. = medicine)
//<def>         definition
//<cs>          collocation section  (containing word combinations)
//<col>         collocation entry (word combination)
//<cd>          collocation definition
//<as>          illustrations of usage (within a <def>. . . </def> field)
//<au>          authority for a definition, or author of a quotation
//<q>           illustrative quotation -- in block quote format
//<au>          author of an illustrative <q> quotation
//<altname>     alternative name for the headword -- essentially a synonym
//<asp>         alternative spelling of the headword
//<syn>         list of synonyms for the headword
//<p>           paragraph
//<b>           bold type
//<it>          italic type


//<p><ent>Abacination</ent><br/
//<hw>A*bac`i*na"tion</hw> <pr>(<adot/*b<acr/s`<icr/*n<amac/"sh<ucr/n)</pr>, <pos>n.</pos> <def>The act of abacinating.</def>  <mark>[R.]</mark><br/
//[<source>1913 Webster</source>]</p>

public class Word {//remember if adding a constructor 

	
	
	String hw;//headword
	String pos;//part of speech
	String pr;//pronunciation
	String def;//definition
	String ety;//etymology
	
	
	public Word(String headword,String pos, String pronunciation, String definition, String etymology){
		this.hw=headword;
		this.pos=pos;
		this.pr=pronunciation;
		this.def=definition;
		this.ety=etymology;
	}
	public Word(){
		
	
	}
	public String getHeadword() {
		return hw;
	}
	public void setHeadword(String headword) {
		this.hw = headword;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getPronunciation() {
		return pr;
	}
	public void setPronunciation(String pronunciation) {
		this.pr = pronunciation;
	}
	public String getDefinition() {
		return def;
	}
	public void setDefinition(String definition) {
		this.def = definition;
	}
	public String getEtymology() {
		return ety;
	}
	public void setEtymology(String etymology) {
		this.ety = etymology;
	}
	
}


