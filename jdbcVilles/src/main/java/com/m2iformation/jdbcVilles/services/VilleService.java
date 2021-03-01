  
package com.m2iformation.jdbcVilles.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.m2iformation.jdbcVilles.ConnectionBDD;
import com.m2iformation.jdbcVilles.models.Ville;
import com.m2iformation.jdbcVilles.repositories.VilleRepository;

public class VilleService implements VilleRepository {

	private Connection connection = ConnectionBDD.getConnection();

	@Override
	public int create(Ville model) {
		int nbRowAffected = -1;
		String req = "insert into ville (id, departement, slug, nom, nomSimple, nomReel, nomSoundex, nomMetaphone, codePostal, numCommune, codeCommune, arrondissement, canton, amdi, pop2010, pop1999, pop2012, densite2010, surface, longitudeDeg, latitudeDeg, longitudeGRD, latitudeGRD, longitudeDMS, latitudeDMS, zMin, zMax) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = connection.prepareStatement(req)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getDepartement());
			pst.setString(3, model.getSlug());
			pst.setString(4, model.getNom());
			pst.setString(5, model.getNomSimple());
			pst.setString(6, model.getNomReel());
			pst.setString(7, model.getNomSoundex());
			pst.setString(8, model.getNomMetaphone());
			pst.setString(9, model.getCodePostal());
			pst.setString(10, model.getNumCommune());
			pst.setString(11, model.getCodeCommune());
			pst.setString(12, model.getArrondissement());
			pst.setString(13, model.getCanton());
			pst.setString(14, model.getAmdi());
			pst.setString(15, model.getPop2010());
			pst.setString(16, model.getPop1999());
			pst.setString(17, model.getPop2012());
			pst.setString(18, model.getDensite2010());
			pst.setString(19, model.getSurface());
			pst.setString(20, model.getLongitudeDeg());
			pst.setString(21, model.getLatitudeDeg());
			pst.setString(22, model.getLongitudeGRD());
			pst.setString(23, model.getLatitudeGRD());
			pst.setString(24, model.getLongitudeDMS());
			pst.setString(25, model.getLatitudeDMS());
			pst.setString(26, model.getZMin());
			pst.setString(27, model.getZMax());

			nbRowAffected = pst.executeUpdate();
		} catch (SQLException s) {
			System.out.println("|" + model.getCodePostal() + "|");
			System.out.println("|" + model.getAmdi() + "|");
			s.printStackTrace();
		}
		return nbRowAffected;
	}

	@Override
	public Ville findByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> findAll() {
		ArrayList<Ville> villes = new ArrayList<>();

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
				v.setNomMetaphone(rs.getString("nomMetaphone"));
				v.setCodePostal(rs.getString("codePostal"));
				v.setNumCommune(rs.getString("numCommune"));
				v.setCodeCommune(rs.getString("codeCommune"));
				v.setArrondissement(rs.getString("arrondissement"));
				v.setCanton(rs.getString("canton"));
				v.setAmdi(rs.getString("amdi"));
				v.setPop2010(rs.getString("pop2010"));
				v.setPop1999(rs.getString("pop1999"));
				v.setPop2012(rs.getString("pop2012"));
				v.setDensite2010(rs.getString("densite2010"));
				v.setSurface(rs.getString("surface"));
				v.setLongitudeDeg(rs.getString("longitudeDeg"));
				v.setLatitudeDeg(rs.getString("latitudeDeg"));
				v.setLongitudeGRD(rs.getString("longitudeGRD"));
				v.setLatitudeGRD(rs.getString("latitudeGRD"));
				v.setLongitudeDMS(rs.getString("longitudeDMS"));
				v.setLatitudeDMS(rs.getString("latitudeDMS"));
				v.setZMin(rs.getString("zMin"));
				v.setZMax(rs.getString("zMax"));

				villes.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}

	public int countOccurence() {
		int count = -1;
		try (Statement st = connection.createStatement()) {
			ResultSet rs = st.executeQuery("SELECT COUNT(*) as c FROM ville");

			if (rs.next()) {
				count = rs.getInt("c");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
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