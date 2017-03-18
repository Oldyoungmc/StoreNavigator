package Graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Items {


	public HashMap<String, String[]> items;
	
	public Items() {
		this.items = new HashMap<String, String[]>();
		this.items.put("vegetables", new String[]{"Ingwer","Kartoffeln","Auberginen","Blumenkohl","Brokkoli","Chicorée","Eisbergsalat","Essiggurken","Feldsalat","Fenchel","Grünkohl","Gurken","Karotten","Kartoffeln","Knoblauch","Kohlrabi","Salat","Lauch","Paprika","Pilze","Radieschen","Rosenkohl","Rucola","Sauerkraut","Sellerie","Spargel","Spinat","Tofu","Tomaten","Zucchini","Zwiebeln"});
		this.items.put("fruits", new String[]{"Ananas","Ä̈pfel","Aprikosen","Bananen","Birnen","Erdbeeren","Feigen","Grapefruit","Kiwi","Kirschen","Mango","Orangen","Pfirsiche","Rosinen","Schwarze","Johannisbeeren","Wassermelonen","Weintrauben", "Zitronen"});
		this.items.put("freshFood", new String[]{"Spätzle", "Maultaschen", "Blätterteig", "Ravioli","Gnocchi", "Kräuterbutterbaguette", "Tortelini"});
		this.items.put("bread", new String[]{"Aufbackbrötchen", "Toast", "Ciabattabrötchen"});
		this.items.put("coffee", new String[]{"Espresso", "Tee", "Kakao"});
		this.items.put("cereals", new String[]{"Müsli", "Kelloggs", "Kolleggs"});
		this.items.put("bakery", new String[]{"Mehl","Zucker","Kuvertüre","Mandeln","Haselnüsse","Salz","Meersalz","Vanilleschoten","Sahnesteif","Backpulver","Trockenhefe","Pudding"});
		this.items.put("noodles", new String[]{"Spaghetti","Rigatoni","Farfalle","Penne","Tagliatelle","Maccharoni"});
		this.items.put("sauces", new String[]{"Passierte Tomaten","Tomatenmark","Paprikamark"});
		this.items.put("eggsAndCreams", new String[]{"Eier","H-Sahne","H-Milch","Schmelzkäse"});
		this.items.put("spices", new String[]{"Pfeffer","Curry","Paprika","Kreuzkümmel","Koriander","Oregano","Basilikum","Kurkuma"});
		this.items.put("internationalFood", new String[]{"Eiernudeln","Glasnudeln","Allrounder","Tortillas","Sojasauce"});
		this.items.put("oilsAndVinegars", new String[]{"Sonnenblumenöl","Balsamicoessig","Walnussöl","Sesamöl","Rapsöl","Trüffelöl"});
		this.items.put("cans", new String[]{"Ravioli"});
		this.items.put("fridge", new String[]{"Butterkäse","Buttermilch","Camembert","Cheddar","Mozarella","Edamer","Emmentaler","Frischkäse","Joghurt","Gouda","Hüttenkäse","Kefir","Milch","Parmesan","Quark","Sahne"});
		this.items.put("wurst", new String[]{"Salami","Schinken","Schwarzwälder Schinken","Serranoschinken","Parmaschinken","Mortadella","Geflügelwurst","Speck", "Wurst"});
		this.items.put("dips", new String[]{"Ketchup","Curryketchup","Senf","Currymangosauce","Mayonaise","Cocktailsauce"});
		this.items.put("meat", new String[]{"Bratwurst","Grillware","Steak","Schnitzel"});
		this.items.put("freezer", new String[]{"Pizza", "Mozarellasticks","TK-Erbsen","TK-Spinat","Eis"});
		this.items.put("drinks", new String[]{"Malzbier","Cola","Apfelsaft","Saft","Orangensaft","Multisaft"});
		this.items.put("sweets", new String[]{"Knoppers","Snickers","Duplo","Amicelli","Schokolade","Gummiware","Süsses","Küsschen","Toffer","Toffifee"});
		this.items.put("chips", new String[]{"Chips", "Pringles","Orientalische","Lays","Taccos"});
		this.items.put("householdSupply", new String[]{"Müllbeutel","Spülschwämme","Spüllappen","Stahlschwämme","Waschmittel","Pampers","Spüli","Toilettenpapier","Küchenpapier"});
		this.items.put("bath", new String[]{"Zahnpasta","Shampoo","Spülung","Zahnbürste","Deo"});
		this.items.put("wine", new String[]{"Rotwein","Weisswein", "Schnaps"});
	}

	public HashMap<String, String[]> getItems() {
		return items;
	}

	public void setItems(HashMap<String, String[]> items) {
		this.items = items;
	}
	
	public String[] getItemListFromCategory(String category){
		return this.items.get(category);
	}
	
	public Set<String> getKeys(){
		return this.items.keySet();
	}
	
	public String getCategoryFromValue(String value){
		Iterator<?> it = this.items.entrySet().iterator();
		String category;
		String[] values;
		while(it.hasNext()){
			@SuppressWarnings("rawtypes")
			HashMap.Entry pair = (HashMap.Entry)it.next();
			category = (String)pair.getKey();
			values = (String[])pair.getValue();
			for (int i = 0; i < values.length; i++){
				if (values[i] == value){
					return category;
				}
			}
		}
		return "No such category";
	}
}