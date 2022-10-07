<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="card">
                        <div class="card-head">
                            <h2>Actualizar Producto</h2>
                        </div>
                        <div class="card-body">
                            <form method="POST" >
                                <div class="mb-3">
                                    <label for="name" class="form-label">Nombre</label>
                                    <input type="name" class="form-control" id="name" name="name" placeholder="Nombre del producto" value="${lista[0].name}" >
                                  
                                </div>
                                <div class="mb-3">
                                   <label for="price" class="form-label">Precio</label>
                                    <input type="price" class="form-control" id="price" name="price" placeholder="Precio del producto"value="${lista[0].price}" >
                                </div>
                               
                                <button type="submit" class="btn btn-success">Actualizar</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>