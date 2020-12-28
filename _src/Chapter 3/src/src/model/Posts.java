package model;

import java.util.Date;
import java.util.List;


public class Posts {

		String title;
		String text;
		Date pubDate;
		
		Authors author;
		
		/**
		 * @return the author
		 */
		public Authors getAuthor() {
			return author;
		}

		/**
		 * @param author the author to set
		 */
		public void setAuthor(Authors author) {
			this.author = author;
		}

		List<Categories> categories;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Date getPubDate() {
			return pubDate;
		}

		public void setPubDate(Date pubDate) {
			this.pubDate = pubDate;
		}

		public List<Categories> getCategories() {
			return categories;
		}

		public void setCategories(List<Categories> categories) {
			this.categories = categories;
		}

		
		public Posts(String title, String text, Date pubDate, Authors author,
				List<Categories> categories) {
			this.title = title;
			this.text = text;
			this.pubDate = pubDate;
			this.author = author;
			this.categories = categories;
		}

		public Posts(){}
	

}
