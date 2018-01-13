/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.macan.brgangularapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab.macan.brgangularapp.entity.Barang;
/**
 *
 * @author User
 */
@Repository
public interface BarangRepo extends JpaRepository<Barang, String> {
	Barang findOneById(String id);
    
    
}
