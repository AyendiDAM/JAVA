package xml;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.transform.Source; 
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class PrimerXML {
    public static void main(String[] args) {
    //Lectura de un archivo xml
    	
    	try {
    		
    		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File("ReinoAnimal.xml"));
			
			NodeList vertebrados=documento.getElementsByTagName("Vertebrados");//nos posicionamos en la etiqueta Vertebrados
			Node animales;
			Element contenido;
			
			NodeList Invertebrados=documento.getElementsByTagName("InVertebrados");
			Node animalesInvertebrados;
			Element contenidoInvertebrados;
			
			for (int i = 0; i < vertebrados.getLength(); i++) {
				
				animales=vertebrados.item(i);// aqui vamos a tener todo lo que este dentro de vertebrados
				
				if (animales.getNodeType()==Node.ELEMENT_NODE) {//Para quitar nodos que no sean tipos de elementos
					
			     contenido=(Element) animales;//le pasamos los valores de los animales 
			     
			  NodeList etiquetasAnumales=contenido.getChildNodes();//nos posicionamos en los hijos de vertebrados 
			  NodeList hijostiquetas=contenido.getChildNodes();//nos posicionamos en los hijos de vertebrados
			  System.out.println("\t*****************");
				System.out.println("\t  "+contenido.getNodeName());//mostramos el nodo que apunta que es vertebrado
				  System.out.println("\t*****************");
			  for (int j = 0; j < etiquetasAnumales.getLength(); j++) {
				Node etiqueta=etiquetasAnumales.item(j);//le pasamos los hijos de contenidos a etiqueta
				Node hijosEtiqueta=hijostiquetas.item(j);//le pasamos los hijos de contenidos a hijosEtiqueta
				if (etiqueta.getNodeType()==Node.ELEMENT_NODE) {
					System.out.print("\t"+hijosEtiqueta.getNodeName());//sacamos el nombre de los nodos que tiene vertebrados
					System.out.println("---->"+etiqueta.getTextContent());//sacamos los textos de los hijos de vertebrados
				}
				
			}
		
				}
			
			}
			
			
			System.out.println();
			//El mismo procedimientos que con vertebrados
			for (int i = 0; i < Invertebrados.getLength(); i++) {
				
				animalesInvertebrados=Invertebrados.item(i);
				
				if (animalesInvertebrados.getNodeType()==Node.ELEMENT_NODE) {
					
			 contenidoInvertebrados=(Element) animalesInvertebrados;
			 
			  NodeList etiquetasAnumales=contenidoInvertebrados.getChildNodes();
			  NodeList hijostiquetas=contenidoInvertebrados.getChildNodes();
			  System.out.println("\t*****************");
			  System.out.println("\t"+contenidoInvertebrados.getNodeName());
			  System.out.println("\t*****************");
			
			  for (int j = 0; j < etiquetasAnumales.getLength(); j++) {
				Node etiqueta=etiquetasAnumales.item(j);
				Node hijosEti=hijostiquetas.item(j);
				if (etiqueta.getNodeType()==Node.ELEMENT_NODE) {
					System.out.print("\t"+hijosEti.getNodeName()+"---->");
					System.out.println(etiqueta.getTextContent());
				}
				
			}
		
				}
			
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    
    }
}


//CREACIÓN XML 
/*try {
DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
DOMImplementation implementacion = builder.getDOMImplementation();

Document documento = implementacion.createDocument(null, "Reaino-Animal", null);
documento.setXmlVersion("1.0");

Element clasificacion_1 = documento.createElement("Vertebrados");




Element anfibios = documento.createElement("Anfibios");
// Crear un nodo de texto con el contenido deseado
Text textoAnfibios = documento.createTextNode("Rana");
anfibios.appendChild(textoAnfibios);
 clasificacion_1.appendChild(anfibios);           
          
Element mamiferos = documento.createElement("Mamiferos");
Text txtMamiferos=documento.createTextNode("Elefante");
mamiferos.appendChild(txtMamiferos);
clasificacion_1.appendChild(mamiferos);        


Element reptiles = documento.createElement("Reptiles");
Text txtReptile=documento.createTextNode("Cocodrilo");
reptiles.appendChild(txtReptile);
clasificacion_1.appendChild(reptiles);        

Element aves = documento.createElement("Aves");
Text txtAves=documento.createTextNode("Aguila");
aves.appendChild(txtAves);
clasificacion_1.appendChild(aves); 

Element peces = documento.createElement("Peces");
Text txtPeces=documento.createTextNode("Delfin");
peces.appendChild(txtPeces);
clasificacion_1.appendChild(peces); 


Element clasificacion_2 = documento.createElement("InVertebrados");


Element cnidarios = documento.createElement("Cnidarios");
Text txtCnidarios=documento.createTextNode("Medusas");
cnidarios.appendChild(txtCnidarios);
clasificacion_2.appendChild(cnidarios); 
          
Element moluscos = documento.createElement("Moluscos");
Text txtMoluscos=documento.createTextNode("Pulpos");
moluscos.appendChild(txtMoluscos);
clasificacion_2.appendChild(moluscos); 

Element anelidos = documento.createElement("Anelidos");
Text txtAnelidos=documento.createTextNode("Lombrices");
anelidos.appendChild(txtAnelidos);
clasificacion_2.appendChild(anelidos); 

Element artropodos = documento.createElement("Artropodos");
Text txtArtropodos=documento.createTextNode("Arañas");
artropodos.appendChild(txtArtropodos);
clasificacion_2.appendChild(artropodos); 

Element poliferos = documento.createElement("Poliferos");
Text txtPoliferos=documento.createTextNode("Esponjas de mar");
poliferos.appendChild(txtPoliferos);

clasificacion_2.appendChild(poliferos); 

Element esquinodermos = documento.createElement("Esquinodermos");
Text txtEsquinodermos=documento.createTextNode("Estrellas de mar");
esquinodermos.appendChild(txtEsquinodermos);
clasificacion_2.appendChild(esquinodermos); 

documento.getDocumentElement().appendChild(clasificacion_1);
documento.getDocumentElement().appendChild(clasificacion_2);




Source source = new DOMSource(documento);
Result result = new StreamResult(new File("ReinoAnimal.xml"));
Transformer transforme = TransformerFactory.newInstance().newTransformer();
transforme.transform(source, result);

System.out.println("creado el xml");

} catch (Exception e) {

}*/