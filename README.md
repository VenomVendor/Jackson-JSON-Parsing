#Demo for [Jackson JSON Parser](https://github.com/FasterXML/jackson)
##prerequisites
 - [jackson-core-2.x.x.jar](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.2.3/jackson-core-2.2.3.jar)
 - [jackson-annotations-2.x.x.jar](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.2.3/jackson-annotations-2.2.3.jar)
 - [jackson-databind-2.x.x.jar](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.2.3/jackson-databind-2.2.3.jar)

Save this <kbd>JSON</kbd> in your server.
##### JSON
	{
	  "first_name": "first_name",
	  "last_name": "last",
	  "city": "Somewhere",
	  "user_user": [
		{
		  "id": "1",
		  "domain": "http://google.com/"
		},
		{
		  "id": "34",
		  "domain": "http://so.com/",
		  "fav_colors": [
			"red",
			"yellow"
		  ]
		},
		{
		  "id": "42",
		  "domain": "http://ww.com/",
		  "fav_colors": [
			"black",
			"green"
		  ]
		}
	  ]
	}

 - Add `    <uses-permission android:name="android.permission.INTERNET" />
` in **`AndroidManifest.xml`**

 - Download JSON in AsyncTask.

##Start Parsing
  - Create Getters and Setters for your JSON
  - Create `Object Mappers`
  - Pass result to object Mappers, with reference class having corresponding Getters and Setters `UserDetails userDetails = objectMapper.readValue(result , UserDetails.class);`

			System.out.println(userDetails.getCity());		//City, FirstName, LastName 
			for(int i = 0; i < userDetails.getUser_user().size(); i++) {
			System.out.println(userDetails.getUser_user().get(i).getId());		// id
			System.out.println(userDetails.getUser_user().get(i).getDomain());		// domain
			try {
				for(int k = 0; k < userDetails.getUser_user().get(i).getFav_colors().size(); k++) {
					System.out.println(userDetails.getUser_user().get(i).getFav_colors().get(k));	//fav_color
				}
			}
			catch (Exception e) {
				System.out.println("NO FAV COLORS");
			}}}
			
##Result
	Somewhere
	1
	http://google.com/
	NO FAV COLORS
	34
	http://so.com/
	red
	yellow
	42
	http://ww.com/
	black
	green
	
	

Author : [VenomVendor](https://www.google.com/#newwindow=1&q=VenomVendor)

