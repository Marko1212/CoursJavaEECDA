package com.m2iformation.jdbcVilles.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.m2iformation.jdbcVilles.ConnectionBDD;
import com.m2iformation.jdbcVilles.models.Ville;
import com.m2iformation.jdbcVilles.repositories.VilleRepository;

public class VilleService implements VilleRepository {
	
	Connection connection = ConnectionBDD.getConnection();

	@Override
	public int create(Ville model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ville findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> findAll() {
		ArrayList<Ville> villes = new ArrayList<>(); 
		// TODO Auto-generated method stub
		try (Statement st = connection.createStatement()) {
			ResultSet rs = st.executeQuery("SELECT * FROM ville");
			while (rs.next()) {
                Ville v = new Ville();
                v.setId(rs.getInt("id"));
                v.setDepartement(rs.getString("departement"));
                v.setSlug(rs.getString("slug"));
                v.setNom(rs.getString("nom"));
                v.setNomSimple(rs.getString("nomSimple"));
                v.setNomReel(rs.getString("nomReel"));
                v.setNomSoundex(rs.getString("nomSoundex"));
                v.setNomMetaphore(rs.getString("nomMetaphone"));
                v.setCodePostal(rs.getString("codePostal"));
                v.setNumeroDeCommune(rs.getString("numCommune"));
                v.setCodeCommune(rs.getString("codeCommune"));
                v.setArrondissement(rs.getString("arrondissement"));
                v.setCanton(rs.getString("canton"));
                v.setAmdi(rs.getString("amdi"));
                v.setPopulation2010(rs.getString("pop2010"));
                v.setPopulation1999(rs.getString("pop1999"));
                v.setPopulation2012(rs.getString("pop2012"));
                v.setDensite2010(rs.getString("densite2010"));
                v.setSuperficie(rs.getString("surface"));
                v.setLongitudeDeg(rs.getString("longitudeDeg"));
                v.setLatitudeDeg(rs.getString("latitudeDeg"));
                v.setLongitudeGrd(rs.getString("longitudeGRD"));
                v.setLatitudeGrd(rs.getString("latitudeGRD"));
                v.setLongitudeDms(rs.getString("longitudeDMS"));
                v.setLatitudeDms(rs.getString("latitudeDMS"));
                v.setAltitudeMin(rs.getString("zMin"));
                v.setAltitudeMax(rs.getString("zMax"));

                villes.add(v);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}

	@Override
	public int update(Integer id, Ville model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
