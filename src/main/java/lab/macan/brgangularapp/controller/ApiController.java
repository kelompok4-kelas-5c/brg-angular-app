package lab.macan.brgangularapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.macan.brgangularapp.entity.Barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import lab.macan.brgangularapp.repo.BarangRepo;


@RestController
public class ApiController {

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama(){
		Map<String, Object> result = new HashMap();
		result.put("nama", "syeh");

		return result;
	}
        @Autowired
        private BarangRepo barangRepo;

	//-- aplikasi mahasiswa 
	@RequestMapping("/daftar-barang")
        public List<Barang> ambilDaftarBarang(){
            return barangRepo.findAll();
        }

    @RequestMapping(value = "/tambah-brg", method = RequestMethod.POST)
    public void tambahData(@RequestBody Barang brg){
    	//System.out.println("nim : " + mhs.getNim());
    	//System.out.println("nama : " + mhs.getNama());
    	//System.out.println("jurusan : " + mhs.getJurusan());
    	barangRepo.save(brg);
    }

    @RequestMapping("/get-brg-by-id/{id}")
    public Barang getBrgById(@PathVariable("id") String id) {
    	return barangRepo.findOneById(id);
    }

    @RequestMapping(value = "/hapus-data/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("id") String id){
        barangRepo.delete(id);
    }


    @RequestMapping("/keluar")
    public void keluar(HttpServletRequest req, 
        HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder
            .getContext().getAuthentication();
        new SecurityContextLogoutHandler()
            .logout(req, resp, auth);
    }


}