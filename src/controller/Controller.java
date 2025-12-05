/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author korisnik
 */
public class Controller {
    
    private DBBroker dbb;
    private List<Knjiga> ListaKnjiga = new ArrayList<>();
    private List<Autor> ListaAutora = new ArrayList<>();

    private static Controller instance;
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
    }
       return instance;
    }
    private Controller() {
        
        dbb=new DBBroker();
      /*  Autor autor1=new Autor("Ivo","Andric",1892,"Biografija autora Ive Andrica bla bla");
        Autor autor2=new Autor("Danilo","Kis",1935,"Biografija autora Danilo Kisa bla bla");
        Autor autor3=new Autor("Mesa","Selimovic",1910,"Biografija autora Mese Selimovica bla bla");
        
        Knjiga knjiga1=new Knjiga("Na drini cuprija",autor1,"1234567890",1945,Zanr.DETEKTIVSKI);
        Knjiga knjiga2=new Knjiga("Basta,pepeo",autor2,"0987654321",1982,Zanr.ISTORIJSKI);
        Knjiga knjiga3=new Knjiga("Tvrdjava",autor3,"1122334455",1970,Zanr.NAUCNA_FANTASTIKA);
        
        ListaKnjiga=new ArrayList<>();
        ListaAutora=new ArrayList<>();
        
        ListaKnjiga.add(knjiga1);
        ListaKnjiga.add(knjiga2);
        ListaKnjiga.add(knjiga3);
        
        ListaAutora.add(autor1);
        ListaAutora.add(autor2);
        ListaAutora.add(autor3);*/
 
    }
    
    public List<Knjiga> getListaKnjiga() {
        return ListaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> ListaKnjiga) {
        this.ListaKnjiga = ListaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return ListaAutora;
    }

    public void setListaAutora(List<Autor> ListaAutora) {
        this.ListaAutora = ListaAutora;
    }
    
    public void obrisiKnjigu(int id,int selektovaniRed) {
        ListaKnjiga=dbb.ucitajListuKnjigaIzBaze();
        
        dbb.obrisiKnjigu(id);
        
        ListaKnjiga.remove(selektovaniRed);  
       
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        dbb.dodajKnjigu(novaKnjiga);
        
        
    //    ListaKnjiga.add(novaKnjiga);
      //  System.out.println("Knjiga je dodata.");
        //System.out.println(ListaKnjiga);
    }

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
       return dbb.ucitajListuKnjigaIzBaze();
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        return dbb.ucitajListuAutorazBaze();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }
    
    
    
}
