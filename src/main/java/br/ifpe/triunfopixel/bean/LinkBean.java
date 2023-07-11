package br.ifpe.triunfopixel.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
@Getter
@Setter
public class LinkBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String linkRetroarch = "https://retroarch.com/index.php?page=platforms";

}
