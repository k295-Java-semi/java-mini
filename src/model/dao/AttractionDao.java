package model.dao;

public interface AttractionDao {

    public void findAllAttractions();

    public void findAttractionById(int id);

    public void createAttraction(String name, String address, String tel, String url);

    public void updateAttraction(int id, String name, String address, String tel, String url);

    public void deleteAttraction(int id);

}
