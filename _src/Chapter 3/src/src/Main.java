import java.util.Date;
import java.util.List;

import model.Authors;
import model.Categories;
import model.Posts;

import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;


public class Main {

	/***
	 * This example works with the minimalblog database created and pre-populated in the chapter 3 
	 * 
	 */
	public static void main(String[] args) {
		//open a connection
		OObjectDatabaseTx db = new OObjectDatabaseTx ("remote:localhost/minimalblog").open("admin", "newadminpass");
		
		//register the model classes
		db.getEntityManager().registerEntityClasses("model");
		
		//load a category
		OSQLSynchQuery<Categories> getCarCategory = new OSQLSynchQuery<Categories>("select from categories where name=?");
		List<Categories> resCategories = db.command(getCarCategory).execute("cars");
		
		//load an author
		OSQLSynchQuery<Authors> getAuthor = new OSQLSynchQuery<Authors>("select from authors where name=?");
		List<Authors> resAuthors = db.command(getAuthor).execute("john");

		Authors john=null;
		if (resCategories.size()!=0 && resAuthors.size()!=0){
			john = resAuthors.get(0);
			//finally create a new post
			//get a proxied object instance
			Posts post = db.newInstance(Posts.class);
			post.setTitle("Post created via object-document mapping");
			post.setText("This is a very important example");
			post.setPubDate(new Date());
			post.setCategories(resCategories);
			post.setAuthor(john);
			db.save( post );
		}
		db.delete(john);
		db.close();
	}

}
