# Java-Web-Crawler-Best-Coursera-Courses
This is a java web crawler that crawls all courses available on Coursera and ranked them in terms of their "Learner Career Outcomes"

Feel free to run the program yourself and get the most updated stats. The whole process takes hald an hour to severals hours depending on your internet speed


## Some Notions from this project 

The top courses that guide one to a new career are mostly about (as of 2020)
- Entrepreneurship
- Marketing
- International 
- Computer Science (Google Cloud, Big Data, etc.)

The top courses that are likely to get one a promotion are mostly about (as of 2020)
- Computer Science
- Management
- Data Analytics

The top courses that give one tangible benefits are mostly about (as of 2020)
- Entrepreneurship 
- Coaching
- Computer Science
- Marketing
- Financing


The following are part of the scraping result (The complete JSON file is also available)

(A value of -1 means that categories does not exist for the course)

New Career Ranking (Top 8)

  {

      "name":"Entrepreneurship Capstone ",

      "id":"S8Vh0SypEeWGvAojQA48rw",

      "slug":"entrepreneurship-capstone",

      "newCareer":83,

      "benefit":89,

      "promotion":43

   },

   {

      "name":"Entrepreneurship 2: Launching your Start-Up",

      "id":"W-hoIJw3EeWJORITtzkPnQ",

      "slug":"wharton-launching-startup",

      "newCareer":83,

      "benefit":74,

      "promotion":17

   },

   {

      "name":"Pilares de Marketing Digital",

      "id":"LEKyOA4REeaX4g6xdats6w",

      "slug":"marketing-digital-pilares",

      "newCareer":81,

      "benefit":77,

      "promotion":15

   },

   {

      "name":"International and Cross-Cultural Negotiation",

      "id":"N7hNkxv9EealIRJP087Tdw",

      "slug":"international-negotiation",

      "newCareer":80,

      "benefit":71,

      "promotion":25

   },

   {

      "name":"Iniciação e Planejamento de Projetos",

      "id":"DNjuwMiiEeetVxL_z0RIpA",

      "slug":"projeto-aplicado",

      "newCareer":80,

      "benefit":50,

      "promotion":-1

   },

   {

      "name":"Strategic Career Self-Management",

      "id":"mqcQFm6vEeWJ-wrnmCvZZw",

      "slug":"strategic-career-self-management",

      "newCareer":80,

      "benefit":25,

      "promotion":-1

   },

   {

      "name":"Introdução ao Big Data ",

      "id":"Z_n14mJbEeehvg5lVNAEzA",

      "slug":"introducao-big-data",

      "newCareer":80,

      "benefit":73,

      "promotion":25

   },

   {

      "name":"Google Cloud Platform Fundamentals: Core Infrastructure en Español",

      "id":"VMZqmE--EeiymQplKkIgcA",

      "slug":"gcp-fundamentals-es",

      "newCareer":75,

      "benefit":60,

      "promotion":50

   }

   Promotion Ranking (Top 8)

  {

      "name":"Fundamentals of Engineering Exam Review",

      "id":"fYg6EC_5EeWUWxIOAnoaFQ",

      "slug":"fe-exam",

      "newCareer":50,

      "benefit":67,

      "promotion":75

   },

   {

      "name":"操作系统原理（Operating Systems）",

      "id":"hA1Im-ckEeWxKxKZYzDvkw",

      "slug":"os-pku",

      "newCareer":25,

      "benefit":50,

      "promotion":67

   },

   {

      "name":"End-to-End Machine Learning with TensorFlow on GCP",

      "id":"V4QRgobREei8Cw6fDgqybg",

      "slug":"end-to-end-ml-tensorflow-gcp",

      "newCareer":71,

      "benefit":80,

      "promotion":62

   },

   {

      "name":"Big Data: el impacto de los datos masivos en la sociedad actual",

      "id":"4faq5hcDEeiLDxJvyy9TxA",

      "slug":"impacto-datos-masivos",

      "newCareer":56,

      "benefit":58,

      "promotion":56

   },

   {

      "name":"Build Your Own iOS App",

      "id":"gqC2SjelEeWnxw5wP_KHTw",

      "slug":"build-app",

      "newCareer":33,

      "benefit":67,

      "promotion":50

   },

   {

      "name":"Marketing Management II",

      "id":"YSVriEeKEeawVwo82dylKw",

      "slug":"marketing-management-two",

      "newCareer":50,

      "benefit":67,

      "promotion":50

   },

   {

      "name":"Introducción a la programación orientada a objetos en Java",

      "id":"YgrvbxeNEeaUCRJWL-pjpQ",

      "slug":"introduccion-programacion-java",

      "newCareer":50,

      "benefit":67,

      "promotion":50

   },

   {

      "name":"Increasing Real Estate Management Profits: Harnessing Data Analytics",

      "id":"QAzkbDGwEeWNuhKLAhom_w",

      "slug":"analytics-capstone",

      "newCareer":27,

      "benefit":47,

      "promotion":50

   },

   Tangible Benefit Ranking (Top 8)

  {

      "name":"Entrepreneurship Capstone ",

      "id":"S8Vh0SypEeWGvAojQA48rw",

      "slug":"entrepreneurship-capstone",

      "newCareer":83,

      "benefit":89,

      "promotion":43

   },

   {

      "name":"Coaching Conversations",

      "id":"ISGr03Q9EeWLqw7zlLhRzQ",

      "slug":"coaching-conversations",

      "newCareer":67,

      "benefit":80,

      "promotion":50

   },

   {

      "name":"Architecting with Google Kubernetes Engine: Foundations",

      "id":"aOin7ERUEemzhg5D25f0SA",

      "slug":"foundations-google-kubernetes-engine-gke",

      "newCareer":67,

      "benefit":80,

      "promotion":33

   },

   {

      "name":"End-to-End Machine Learning with TensorFlow on GCP",

      "id":"V4QRgobREei8Cw6fDgqybg",

      "slug":"end-to-end-ml-tensorflow-gcp",

      "newCareer":71,

      "benefit":80,

      "promotion":62

   },

   {

      "name":"Pilares de Marketing Digital",

      "id":"LEKyOA4REeaX4g6xdats6w",

      "slug":"marketing-digital-pilares",

      "newCareer":81,

      "benefit":77,

      "promotion":15

   },

   {

      "name":"Entrepreneurship 4: Financing and Profitability",

      "id":"yXMpEJw3EeW6bw4ogk2HGQ",

      "slug":"wharton-entrepreneurship-financing-profitabilty",

      "newCareer":71,

      "benefit":76,

      "promotion":25

   },

   {

      "name":"L\u0027entrepreneuriat social : de l\u0027envie au projet",

      "id":"XZNGlISTEeWxQQoymFg8zQ",

      "slug":"entrepreneuriatquichangelemonde",

      "newCareer":50,

      "benefit":75,

      "promotion":-1

   },

   {

      "name":"Marketing e vendas B2B: Fechando novos negócios",

      "id":"FRhDDa3KEeeN3goWo4mKhg",

      "slug":"marketing-vendas-b2b",

      "newCareer":50,

      "benefit":75,

      "promotion":-1

   }
   
   
   
