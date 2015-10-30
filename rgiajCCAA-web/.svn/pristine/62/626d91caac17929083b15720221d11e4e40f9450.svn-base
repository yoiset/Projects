<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<script type="text/javascript">

   
</script>

<div class="contenedor_columnas"> 
	<!-- COL. CENTRO -->
	<div class="columna4 ultimaColumna">
		<div class="panel2 close">
        	<div class="novedades">
	            <br />
				<h2 class="info error" style="padding-left:60px;font-size: 18">
					<span id="myPendingMessageId">
            			<label for=summary>${model.summary}</label>
                    </span>
					<span>
						<label for=details>${model.details}</label>
					</span>
					<br />
					<span>
						<c:forEach items="${model.trace}" var="item">
							<label for=lefty>${item.lefty}</label>
							<br/>
							<label for=righty>${item.righty}</label>
							<br/><br/><br/><br/>
						</c:forEach>	      
					</span>
				</h2>
				<br />
			</div>	
		</div>
	</div>	
</div>  	
</html>								
