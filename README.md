| [Using Java 7 client with MJSONWP protocol](../java_7) | Using Java 8 client with w3c protocol |
|------------------------------------------------------- | ------------------------------------- |

1. What is Lighthouse?	3
    2. What Metrics Does Google Lighthouse Measure?............................................................ 3
3. Running Lighthouse	3
4. Jmeter Integration	5
5. Operational Scenarios	7




What is Lighthouse?
Google Lighthouse is a free tool that provides powerful insights to help improve your website. By generating a Lighthouse report, you can assess any web page’s page experience and access valuable tips to improve its performance.
Google has recently increased emphasis on-page experience, including adding a new set of Core Web Vital signals. The signals break down how a user experiences your page, and you can see how your website performs in this area through Lighthouse.
Since Lighthouse is a Google application, it could be a great way to see your website in the way that Google might see it, knowing any recommendations come straight from the search engine giant itself. 


What Metrics Does Google Lighthouse Measure?
Each Lighthouse report has five categories: performance, accessibility, best practices, SEO, and progressive web app. 

With a clear 1-100 grading system, Lighthouse allows you to audit your pages and find areas for improvement. You can expand each section to get in-depth insights and find places where you can quickly improve your page, as shown in the screenshot below.
 
•Speed Index: The time it takes for the content to visually appear during page load.
•Time to Interactive: The time it takes for the page to become fully interactive.
•Total Blocking Time: The sum of time between FCP and full interactivity.
•First Contentful Paint (FCP): The time it takes for the first text or image asset to load.
•Largest Contentful Paint (LCP): The time it takes for the largest text or image asset to load.
•First Input Delay (FID): The time it takes for the browser to respond to the user’s first interaction.
•Cumulative Layout Shift (CLS): This measures any movement of the page in the viewport.



Running Lighthouse?

1.Using Lighthouse in Chrome DevTools:
Lighthouse is integrated directly into the Chrome DevTools, under the "Lighthouse" panel.
Installation: install Chrome.
Run it: open Chrome DevTools, select the Lighthouse panel, and hit "Generate report".

 


2.Using the Node CLI
The Node CLI provides the most flexibility in how Lighthouse runs can be configured and reported. Users who want more advanced usage, or want to run Lighthouse in an automated fashion should use the Node CLI.

Lighthouse requires Node 14 LTS (14.x) or later.

Installation:

npm install -g lighthouse
# or use yarn:
# yarn global add lighthouse
Run it: lighthouse https://airhorner.com/

By default, Lighthouse writes the report to an HTML file. You can control the output format by passing flags.
 
3.Via Java Programatically
Here we run the lighthouse command via a Java compiler. The java compiler basically triggers the Lighthouse CLI command from its interface using predefined java functions.



Prerequisites:
1.	Windows OS
2.	Java 1.8+
3.	NodeJS 14.x 
4.	Lighthouse.( npm install -g lighthouse)



Jmeter Integration
Here we use a lighthouse JAR file. The Jar file basically contains the Util to run lighthouse programmatically as mentioned above in point 3.

The Jar file is supposed to be added to your Jmeter library before run . The call can be made within your steps by importing the lighthouse library and calling the Lighthouse function.

The lighthouse function requires 2 parameter:
1.	Url
2.	Port number

The URL will be the target page you are looking for performance and port number will be the port number of chrome instance on which the URL exists.

Significance to provide Port number is for the purpose of internal links. Since to fetch reports of authenticated pages lighthouse needs to be on the same port of chrome where the authentication is done for the respective page. 
