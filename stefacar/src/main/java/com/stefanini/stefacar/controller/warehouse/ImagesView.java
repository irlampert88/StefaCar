package com.stefanini.stefacar.controller.warehouse;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> imagens;
     
    @PostConstruct
    public void init() {
        imagens = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            imagens.add("nature" + i + ".jpg");
        }
    }
 
    public List<String> getImagens() {
        return imagens;
    }
    
    
    
    
    
}
