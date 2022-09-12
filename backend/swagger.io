openapi: 3.0.0
info:
  version: 1.0.0
  title: Student API
  description: This is swaggerspec of the Progent API, The first call must be the /login in order to obtain the "sessionid" all subsequent calls must contain "username" and "sessionid".
  contact: 
    name: Sergiu Velescu
    url: https://hello.com
    email: qwe@qwe.md
servers:
  - url: http:asd.com
    description: First server
  - url: http://zxc.com
    description: Second server  
paths:
  /demo:
    get:
      description: obtain info from HR db
      parameters:
        - name: empAge
          in: query
          description: Get emp. by age
          schema:
            type: integer
            minimum: 0
            maximum: 100
            example: 34
        - name: empName
          in: query
          description: Get emp. by name
          schema:
            type: string
            example: Sergiu            
      responses:
       200:
         description: Success full desc
         content:
           application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/employee'                    
    post:
      description: Create a new employee
      requestBody:
        required: true
        content: 
          application/json:
            schema:
              $ref: '#/components/schemas/employee'
      responses:
        200:
          description: success call
  /employees/{id}:
    get:
      description: Obtain emp Info
      parameters:
        - in: path
          name: id
          required: true
          schema:
            type: integer
            example: 54
      responses:
        200:
         description: Success get emp by id
         content:
           application/json:
              schema:
                $ref: '#/components/schemas/employee'
  /login:
    post:
      description: Authenticate user/pass and return SessionID
      parameters:
        - name: username
          in: query
          description: Username
          schema:
            type: string
            example: qwe@asd.com    
        - name: passwd
          in: query
          description: Password
          schema:
            type: string
            example: secret             
      responses:
        200:
          description: success call
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/loginSuccessResp'  
  /products:
    post:
      description: xxx yyy zzz
      parameters:
        - $ref: '#/components/parameters/requestUsername'
        - $ref: '#/components/parameters/requestSessionid'   
        - name: filter
          in: query
          description: The item ID
          schema:
            type: string
            example: brandName like 'adidas%' and size in (41,42)            
      responses:
        200:
          description: success call
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/requestResponce'  
                
                
                
                
                
                
components:
  schemas:
    employee:
      description: Model containing emp. info
      properties:
        id:
          type: integer
          example: 4
        emp_name:
          type: string
          example: Sergiu         
        emp_title:
          type: string
          example: DBA  
    loginSuccessResp:          
      description: Succesfull authentication
      properties:
        responce:
          type: string
          example: OK
        message:
          type: string
          example: Login Success     
        data:
          type: object
          properties:
            sessionid:
              type: string
    requestResponce:          
      description: Succesfull authentication
      properties:
        responce:
          type: string
          example: OK
        message:
          type: string
          example: Success     
        data:
          type: object
          properties:
            column1:
              type: string              
  parameters:
    requestUsername:
      in: query
      name: username
      required: true
      schema:
        type: string
        example: qwe@asd.com
      description: Username  
    requestSessionid:
      in: query
      name: sessionid
      required: true
      schema:
        type: string
        example: qwe123asdzxc
      description: SessionID        
                  
