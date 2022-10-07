/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Config.Conexion;
import Model.Producto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexis
 */
@Controller
public class ProductoController {

    Conexion con = new Conexion();
    JdbcTemplate template = new JdbcTemplate(con.conexion());
    ModelAndView mv = new ModelAndView();
    List datos;
    int id;

    @RequestMapping("index.htm")
    public ModelAndView index() {
        String sql = "SELECT * FROM product  WHERE status=1";
        datos = this.template.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("index");

        return mv;
    }

    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mv.setViewName("agregar");
        return mv;
    }

    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView agregar(Producto product) {
        String sql = "INSERT INTO product (name,price,status) values(?,?,1)";
        this.template.update(sql, product.getName(), product.getPrice());
        return new ModelAndView("redirect:/index.htm");

    }

    @RequestMapping(value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "SELECT * FROM product WHERE id=" + id;
        datos = this.template.queryForList(sql);
        mv.addObject("lista", datos);
        mv.setViewName("editar");

        return mv;
    }

    @RequestMapping(value = "editar.htm", method = RequestMethod.POST)
    public ModelAndView editar(Producto product) {
        String sql = "UPDATE product SET name=? , price=? WHERE id=" + id;
        this.template.update(sql, product.getName(), product.getPrice());
        return new ModelAndView("redirect:/index.htm");
    }

    @RequestMapping(value = "eliminar.htm")
    public ModelAndView eliminar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "UPDATE product SET status=0 WHERE id=" + id;
        this.template.update(sql);
        return new ModelAndView("redirect:/index.htm");

    }

}
