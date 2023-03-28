<!DOCTYPE html>
<html>
<head>
	<title>${name} Catalog</title>
</head>
<body>
	<h1>${name} Catalog</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Location</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<#list docs as doc>
			<tr>
				<td>${doc.id}</td>
				<td>${doc.title}</td>
				<td>${doc.location}</td>
				<td>
					<#list doc.tags as key, value>
					${key}: ${value}<br>
					</#list>
				</td>
			</tr>
			</#list>
		</tbody>
	</table>
</body>
</html>